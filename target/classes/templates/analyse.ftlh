<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
<h3 class="text-center mb-5">Рейтинг фільмів</h3>
        <form action="/analyse/film/category" method="get">
            <div class="form-group mb-2">
                <select class="custom-select" name="idCategory">
                  <option selected value="${selectedFilm?if_exists.id?if_exists}">${selectedFilm?if_exists.name?if_exists}</option>
                  <#list filmCategories as category>
                  <option value="${category.id}">${category.name}</option>
                  </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Знайти</button>
        </form>
        <table class="table mt-5 mb-5">
             <thead class="thead-dark">
                   <tr>
                      <th scope="col">Назва</th>
                      <th scope="col" class="text-center">Рік</th>
                      <th scope="col" class="text-center">Ціна</th>
                      <th scope="col" class="text-center">Категорія</th>
                      <th scope="col" class="text-center">Рейтинг</th>
                   </tr>
             </thead>
             <tbody>
                  <#list ratingFilm as film>
                       <tr>
                            <td>${film.name}</td>
                            <td class="text-center">${film.year?c}</td>
                            <td class="text-center">${film.price}</td>
                            <td class="text-center">${film.nameFC}</td>
                            <td class="text-center">${film.rating}</td>
                       </tr>
                  </#list>
             </tbody>
        </table>

<h3 class="text-center mb-5">Рейтинг композицій</h3>
        <form action="/analyse/music/category" method="get">
            <div class="form-group mb-2">
                <select class="custom-select" name="idCategory">
                  <option selected value="${selectedMusic?if_exists.id?if_exists}">${selectedMusic?if_exists.name?if_exists}</option>
                  <#list musicCategories as category>
                  <option value="${category.id}">${category.name}</option>
                  </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mt-3">Знайти</button>
        </form>
        <table class="table mt-5 mb-5">
             <thead class="thead-dark">
                   <tr>
                      <th scope="col">Назва</th>
                      <th scope="col" class="text-center">Виконавець</th>
                      <th scope="col" class="text-center">Ціна</th>
                      <th scope="col" class="text-center">Категорія</th>
                      <th scope="col" class="text-center">Рейтинг</th>
                   </tr>
             </thead>
             <tbody>
                  <#list ratingMusic as music>
                       <tr>
                            <td>${music.name}</td>
                            <td class="text-center">${music.performer}</td>
                            <td class="text-center">${music.price}</td>
                            <td class="text-center">${music.nameMC}</td>
                            <td class="text-center">${music.rating}</td>
                       </tr>
                  </#list>
             </tbody>
        </table>

</@c.page>