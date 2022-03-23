<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="row mb-3">
    <div class="col-2"></div>
        <div class="col-10 mb-3" style="display: flex;" style="width: 18rem;">
          <img src="https://freesvg.org/img/abstract-user-flat-1.png" class="card-img-top mt-2" style="width: 20%;" class="col-4">
          <div class="mt-5 ml-5 col-8">
                <i><b>ПІБ: </b></i>${user.fullName}<br/>
                <i><b>Логін: </b></i>${user.username}<br/>
                <i><b>Пароль: </b></i>${user.password}<br/>
                <i><b>Баланс грошей: </b></i>${user.money}<br/>
                <i><b>Баланс бонусів: </b></i>${user.balance.bonuses}<br/>
                <form action="/user/${user.id}" method="get">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input type="hidden" name="id" value="${user.id}" />
                    <button type="submit" class="btn btn-success mt-3">Змінити</button>
                </form>
          </div>
        </div>
    </div>


</@c.page>