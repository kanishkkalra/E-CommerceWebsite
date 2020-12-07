import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Product } from './product';
import { Observable } from 'rxjs';

const myHeader={
  headers:new HttpHeaders({'Content-type':'application/json',
  'Access-Control-Allow-Origin':'*'
  })
}

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor(private http:HttpClient) { }

  listproducts():Observable<Product[]>{
    return this.http.get<Product[]>("http://localhost:9191/products");
  }

  register(pro: Product) : Observable<Product>{
    return this.http.post<Product>("http://localhost:9191/addProduct",pro,myHeader);
  }
}
