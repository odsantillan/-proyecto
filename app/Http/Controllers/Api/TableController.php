<?php

namespace App\Http\Controllers\Api;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class TableController extends Controller
{
  function all() {
      $usuarios = \App\Table::all();
      return $usuarios;
  }
}
