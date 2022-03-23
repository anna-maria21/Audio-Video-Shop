<#import "parts/common.ftlh" as c>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default" style="margin-top:45px">
            <div class="panel-heading">
                <h3 class="panel-title">Редагувати композицію</h3>
            </div>
            <div class="panel-body">
                <form action="/musics/edit" method="post">
                    <div class="form-group mt-3">
                        <#if message??>
                            <p style="color: red;">Уже такє єсть!</p>
                        </#if>
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Назва:</label>
                        <input type="text" class="form-control" name="name" value="${musics.name}" required>
                    </div>

                    <div class="form-group mb-2">
                        <label for="name">Виконавець:</label>
                        <input type="text" class="form-control" name="performer" value="${musics.performer}" required>
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Рік виходу:</label>
                        <input type="number" class="form-control" name="year" value="${musics.year?c}" required>
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Рейтинг:</label>
                        <input type="number" class="form-control" name="rating" value="${musics.rating}" required>
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Ціна:</label>
                        <input type="number" class="form-control" name="price" value="${musics.price}" required>
                    </div>
                    <div class="form-group mb-2">
                        <label for="group">Категорія:</label>
                        <select class="custom-select" name="idMusicCategory">
                        <option selected value="${musics.musicCategory.id}">${musics.musicCategory.name}</option>
                          <#list categories as category>
                          <option value="${category.id}">${category.name}</option>
                          </#list>
                        </select>
                    </div>
                    <div class="form-group mb-2">
                        <label for="group">Тип продукту:</label>
                        <select class="custom-select" name="idType">
                        <option selected value="${musics.type.id}">${musics.type.name}</option>
                          <#list types as type>
                          <option value="${type.id}">${type.name}</option>
                          </#list>
                        </select>
                    </div>
                    <input type="hidden" value="${musics.id}" name="id">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-success">Змінити запис</button>
                </form>
            </div>
        </div>
    </div>
</div>
</@c.page>