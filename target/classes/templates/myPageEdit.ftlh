<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6 col-md-offset-3">
        <div class="panel panel-default" style="margin-top:45px">
            <div class="panel-heading">
                <h3 class="panel-title">Зміна користувачів</h3>
            </div>
            <div class="panel-body">
                <form action="/user" method="post">
                    <div class="form-group mb-2">
                        <label for="name">ПІБ:</label>
                        <input type="text" class="form-control" name="fullName" value="${user.fullName?if_exists}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Логін:</label>
                        <input type="text" class="form-control" name="username" value="${user.username}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Пароль:</label>
                        <input type="text" class="form-control" name="password" value="${user.password}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Баланс грошей:</label>
                        <input type="text" class="form-control" name="money" value="${user.money}">
                    </div>
                    <div class="form-group mb-2">
                        <label for="name">Баланс бонусів:</label>
                        <input type="text" class="form-control" name="bonuses" value="${user.balance.bonuses}" readonly>
                    </div>
                    <input type="hidden" value="${user.id}" name="userId">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button type="submit" class="btn btn-success">Зберегти</button>
                </form>
            </div>
        </div>
    </div>
</div>
</@c.page>