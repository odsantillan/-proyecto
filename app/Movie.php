<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Movie extends Model
{
    //
    protected $fillable = ["pelicula", "director", "descrpción", "servicio1", "servicio2"];
    
}
