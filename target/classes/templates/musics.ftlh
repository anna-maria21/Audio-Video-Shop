<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1 class="text-center">Додати композицію</h1>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
        <form action="/musics" method="post">
            <div class="form-group mt-3">
                <#if message??>
                    <p style="color: red;">Уже такє єсть!</p>
                </#if>
            </div>
            <div class="form-group mb-2">
                <label for="name">Назва:</label>
                <input type="text" class="form-control" name="name" value="${tempMusic?if_exists.name?if_exists}" minlength="2" maxlength="30" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Виконавець:</label>
                <input type="text" class="form-control" name="performer" value="${tempMusic?if_exists.performer?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Рік виходу:</label>
                <input type="number" class="form-control" name="year" value="${tempMusic?if_exists.year?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Рейтинг:</label>
                <input type="number" class="form-control" name="rating" value="${tempMusic?if_exists.rating?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="name">Ціна:</label>
                <input type="number" class="form-control" name="price" value="${tempMusic?if_exists.price?if_exists}" required>
            </div>
            <div class="form-group mb-2">
                <label for="group">Категорія:</label>
                <select class="custom-select" name="idMusicCategory">
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
            <form method="get" action="/musics">
                <input type="text" class="form-control" placeholder="category" name="filter" value="${filter?if_exists}">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-info ml-3">Знайти</button>
            </form>
        </div>
    </div>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10 col-md-offset-1 mb-5">
        <h1 class="text-center">Список композицій</h1>
        <#if emptyMessage??>Немає композицій</#if>
        <ul class="list-group">
            <#list musics as music>
                <li class="list-group-item mt-2">
                    <div class="wrapper" style="display: flex">
                        <div style="display: block" class="col-6">
                            <i><b>Назва: </b></i>${music.name}<br/>
                            <i><b>Виконавець: </b></i>${music.performer}<br/>
                            <i><b>Рік випуску: </b></i>${music.year?c}<br/>
                            <i><b>Рейтинг: </b></i>${music.rating}<br/>
                            <i><b>Ціна: </b></i>${music.price}<br/>
                            <i><b>Категорія: </b></i>${music.musicCategory.name}<br/>
                            <i><b>Тип товару: </b></i>${music.type.name}<br/>
                        </div>
                        <div style="display: block; text-align: right" class="col-6">
                            <form method="get" action="/musics/edit/${music.id}" class="mt-4">
                                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-success">Змінити</button>
                            </form>
                            <form method="post" action="/musics/delete" class="mt-4">
                                <input type="hidden" value="${music.id}" name="id">
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