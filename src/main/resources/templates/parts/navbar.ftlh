<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-dark navbar-expand-lg bg-dark pl-5 pr-5">
      <a class="navbar-brand pl-5" href="/">M & F  Shop</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
            <#if isAdmin>
              <li class="nav-item active">
                <a class="nav-link" href="/analyse">Рейтинг <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="/films">Фільми <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="/musics">Музика <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="/user">Користувачі <span class="sr-only">(current)</span></a>
              </li>
            </#if>
          <li class="nav-item active">
            <form method="get" action="/my">
            <#if user??><input type="hidden" name="id" value="${id}"></#if>
            <button type="submit" class="btn btn-outline-light">Моя сторінка</button>
            </form>
          </li>


        </ul>
            <div class="navbar-text pr-5">${name}</div>
        <#if name != "unknown">
            <@l.logout />
        </#if>
      </div>
</nav>