import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ProductsComponent} from "./products/products.component";
import {ProductComponent} from "./product/product.component";
import {EditProductComponent} from "./edit-product/edit-product.component";

export const routes: Routes = [
  { path : "home" , component : HomeComponent },
  { path : "" , redirectTo : "home" , pathMatch : "full" },
  { path : "products" , component : ProductsComponent },
  { path : "product" ,  component : ProductComponent },
  { path : "editProduct/:id" ,  component : EditProductComponent },
];
