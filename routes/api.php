<?php

use Illuminate\Http\Request;
use App\Table;
use App\Movies;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('usuarios', function() {
  // If the Content-Type and Accept headers are set to 'application/json',
  // this will return a JSON structure. This will be cleaned up later.
  return Table::all();
});

Route::get('usuarios/{email}', function($email) {
  return Table::all()->where("email",$email);
});

Route::post('usuarios', function(Request $request) {
  Table::create($request->json()->all());
  return Table::all();
});

Route::put('usuarios/{id}', function(Request $request, $id) {
  $contact = Table::findOrFail($id);
  $contact->update($request->all());

  return $article;
});

Route::delete('usuarios/{id}', function($id) {
  Contact::find($id)->delete();

  return Contact::all();
});

Route::get('peliculas', function() {
  // If the Content-Type and Accept headers are set to 'application/json',
  // this will return a JSON structure. This will be cleaned up later.
  return Movies::all();
});



Route::post('peliculas', function(Request $request) {
  Movies::create($request->json()->all());
  return Movies::all();
});

Route::put('peliculas/{id}', function(Request $request, $id) {
  $contact = Movies::findOrFail($id);
  $contact->update($request->all());

  return $article;
});

Route::delete('peliculas/{id}', function($id) {
  Movies::find($id)->delete();

  return Movies::all();
});
Route::get('peliculas/{estado}', function($estado) {
  return Movies::all()->where("estado",$estado);
});