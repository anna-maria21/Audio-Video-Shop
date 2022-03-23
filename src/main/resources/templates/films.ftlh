<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1 class="text-center">Додати фільм</h1>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
        <form action="/films" method="post">
            <div class="form-group mt-3">
                <#if message??>
                    <p style="color: red;">Такий фільм уже існує!</p>
                </#if>
            </div>
            <div class="form-group mb-2">
                <label for="name">Назва:</label>
                <input type="text" class="form-control" name="name" value="${tempFilm?if_exists.name?if_exists}" minlength="2" maxlength="30" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Режисер:</label>
                <input type="text" class="form-control" name="director" value="${tempFilm?if_exists.director?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Опис:</label>
                <input type="text" class="form-control" name="description" value="${tempFilm?if_exists.description?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Рік виходу:</label>
                <input type="number" class="form-control" name="year" value="${tempFilm?if_exists.year?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Рейтинг:</label>
                <input type="number" class="form-control" name="rating" value="${tempFilm?if_exists.rating?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Ціна:</label>
                <input type="number" class="form-control" name="price" value="${tempFilm?if_exists.price?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="group">Категорія:</label>
                <select class="custom-select" name="idFilmCategory">
                  <option selected>Оберіть категорію зі списку</option>
                  <#list categories as category>
                  <option value="${category.id}">${category.name}</option>
                  </#list>
                </select>
            </div>
            <div class="form-group mb-2">
                <label for="group">Тип продукту:</label>
                <select class="custom-select" name="idType">
                  <option selected>Оберіть тип зі списку</option>
                  <#list types as type>
                  <option value="${type.id}">${type.name}</option>
                  </#list>
                </select>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary mt-3">Додати</button>
        </form>
        </div>
        </div>
    <div class="form-row form-inline mt-5 mb-3">
    <div class="col-md-1"></div>
        <div class="form-group col-md-10">
            <form method="get" action="/films">
                <input type="text" class="form-control" placeholder="Назва фільму" name="filter" value="${filter?if_exists}">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-info ml-3">Знайти</button>
            </form>
        </div>
    </div>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10 col-md-offset-1 mb-5">
        <h1 class="text-center">Список фільмів</h1>
        <#if emptyMessage??>Немає фільмів</#if>
        <ul class="list-group">
            <#list films as film>
                <li class="list-group-item mt-2">
                    <div class="wrapper" style="display: flex">
                        <div style="display: block" class="col-9">
                            <i><b>Назва: </b></i>${film.name}<br/>
                            <i><b>Режисер: </b></i>${film.director}<br/>
                            <i><b>Опис: </b></i>${film.description}<br/>
                            <i><b>Рік випуску: </b></i>${film.year?c}<br/>
                            <i><b>Рейтинг: </b></i>${film.rating}<br/>
                            <i><b>Ціна: </b></i>${film.price}<br/>
                            <i><b>Категорія: </b></i>${film.filmCategory.name}<br/>
                            <i><b>Тип товару: </b></i>${film.type.name}<br/>
                        </div>
                        <div style="display: block; text-align: right" class="col-3">
                            <form method="get" action="/films/edit/${film.id}" class="mt-4">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-success">Змінити</button>
                            </form>
                            <form method="post" action="/films/delete" class="mt-4">
                                <input type="hidden" value="${film.id}" name="id">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-danger">Видалити</button>
                            </form>
                        </div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>
</div>

</@c.page>