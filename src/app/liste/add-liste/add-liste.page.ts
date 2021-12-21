import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import * as XLSX from 'xlsx';
import { ListeServiceService } from '../service/liste-service.service';
type AOA = any[][];

@Component({
  selector: 'app-add-liste',
  templateUrl: './add-liste.page.html',
  styleUrls: ['./add-liste.page.scss'],
})
export class AddListePage implements OnInit {
  liste = {nom: '', fichier: ''};
  error = '';
  apprenants:any[]=[];
  listeApp: any;
  @ViewChild('inputFile') inputFile!: ElementRef;
  isExcelFile!:boolean;
  spinnerEnabled=false;
  keys!:string[];
  name = 'Angular';
  fileName: string = 'SheetJS.xlsx';
  datas: any;
  data:any;
  headData: any // excel row header

  constructor(
    private router: Router,
    private service: ListeServiceService
  ) { }

  ngOnInit() {
  }

  /* <input type="file" (change)="onFileChange($event)" multiple="false" /> */
  /* ... (within the component class definition) ... */
  onFileChange(evt: any) {
    // let data: any, header;
    const target : DataTransfer = <DataTransfer>(evt.target);
    this.isExcelFile = !!target.files[0].name.match(/(.xls|.xlsx)/);
    if(target.files.length > 1) {
      this.inputFile.nativeElement.value= '';
    }

    if(this.isExcelFile){
      this.apprenants=[];
      this.spinnerEnabled = true;
      const reader: FileReader = new FileReader();
      reader.onload = (e: any) =>{
        // lire le classeur
        const bstr: string = e.target.result;
        const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary'});

        // saisir la première feuille
        const wsname: string = wb.SheetNames[0];
        const ws: XLSX.WorkSheet = wb.Sheets[wsname];

        // enregistrer des données

        this.datas = XLSX.utils.sheet_to_json(ws);
        console.log(this.datas);
        const ws2: XLSX.WorkSheet = wb.Sheets[wb.SheetNames[1]];
        this.readDataSheet(ws2, 10);
      };

      reader.readAsBinaryString(target.files[0]);
      reader.onloadend = (e) => {
        this.spinnerEnabled = false;
        this.keys = Object.keys(this.datas[0]);
      }

      this.PreviewFichier(evt);
    }else{
      this.inputFile.nativeElement.value = '';
    };
  }

  PreviewFichier(evt: any) {
    /* wire up file reader */
    const target: DataTransfer = <DataTransfer>evt.target;
    if (target.files.length !== 1) throw new Error('Cannot use multiple files');
    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {
      /* read workbook */
      const bstr: string = e.target.result;
      const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });

      /* grab first sheet */
      const wsname: string = wb.SheetNames[0];
      const ws: XLSX.WorkSheet = wb.Sheets[wsname];

      /* save data */
      this.data = <AOA>(
        XLSX.utils.sheet_to_json(ws, { header: 1, raw: false, range: 0 })
      );
      console.log(this.data[1]);

      this.headData = this.data[0];
      this.data = this.data.slice(1); // remove first header record

      const ws2: XLSX.WorkSheet = wb.Sheets[wb.SheetNames[1]];
      this.readDataSheet(ws2, 10);
    };
    reader.readAsBinaryString(target.files[0]);
  }

  private readDataSheet(ws: XLSX.WorkSheet, startRow: number) {
    /* save data */
    let datas = <AOA>(
      XLSX.utils.sheet_to_json(ws, { header: 1, raw: false, range: startRow })
    );
    console.log(datas[1]);
    let headDatas = datas[0];
    datas = datas.slice(1); // remove first header record

    for (let i = 0; i < this.data.length; i++) {
      this.data[i][this.headData.length] = datas.filter(
        (x) => x[12] == this.data[i][0]
      );
    }
    console.log(this.data[1]);
  }

  addListe(form: NgForm){
    let formats = localStorage.getItem('userData');
    let format = JSON.parse(formats)
    this.listeApp = {nom_liste: form.value["nom"], date_liste: new Date(), formateur: format};
    this.service.addListe(this.listeApp).subscribe((app: any)=>{
      console.log(app);
      
      if(app){
         
         for(let i=0; i<this.datas.length; i++){
          this.apprenants.push({
            nom_complet:this.datas[i].nom_complet,
            numero:this.datas[i].numero,
            email:this.datas[i].email,
            liste: app,
         });
         console.log(this.apprenants);
         
        }

        this.service.addListeExcel(this.apprenants).subscribe((data: any)=>{
          this.router.navigate(['liste']);
        })
      }
    })
  }
}
