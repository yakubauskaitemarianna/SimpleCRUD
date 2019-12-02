# Лабораторная работа №1. Изучение протокола HTTP.

## Запрос OPTIONS.

Запрос OPTIONS - используется для описания параметров соединения с целевым ресурсом.
Ответ на запрос содержит allow-заголовок с поддерживаемыми методами.

`https://mail.ru`

OPTIONS  HTTP/1.1

Host: mail.ru

В результате запроса ресурс был найден, однако method is not allowed.

```
HTTP/1.1 400
Server: nginx/1.14.1
Date: Sun, 22 Sep 2019 16:57:10 GMT
Content-Type: text/html
Transfer-Encoding: chunked
Connection: keep-alive
X-XSS-Protection: 1; mode=block; report=https://cspreport.mail.ru/xxssprotection
X-Content-Type-Options: nosniff
```

`http://ya.ru`

OPTIONS  HTTP/1.1

Host: ya.ru

```
HTTP/1.1 403 Forbidden
ETag: W/"5d853bae-3077"
Content-Type: text/html; charset=utf-8
Date: Sun, 22 Sep 2019 16:58:43 GMT
Content-Length: 12407
X-Content-Type-Options: nosniff
```

Отказ авторизации запроса.

 `https://www.rambler.ru`
 
OPTIONS  HTTP/1.1

Host: www.rambler.ru

Вид страницы запроса (он того стоит).

```
Доступ запрещен
Поздравляем, вы нашли тайную дверь.

Но дальше вы пройти не сможете.

Попробуйте начать заново с главной Рамблера

```

Ответ с сервера. Код 403. (сервер отказывается авторизовать запрос)

```
HTTP/1.1 403 Forbidden
Server: nginx
Date: Sun, 22 Sep 2019 17:01:06 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 11231
Connection: keep-alive
Keep-Alive: timeout=50
Vary: Accept-Encoding
Last-Modified: Tue, 20 Aug 2019 11:13:28 GMT
Vary: Accept-Encoding
ETag:  W/"5d853bae-3077"
X-Cache: REVALIDATED
Set-Cookie: ruid=vAsAAHPRhF0HYBRuAVXYKQB=; expires=Thu, 31-Dec-37 23:55:55 GMT; domain=.rambler.ru; path=/
P3P: CP="NON DSP NID ADMa DEVa TAIa PSAa PSDa OUR IND UNI COM NAV"
```

`https://www.google.ru` 

OPTIONS  HTTP/1.1

Host: www.google.ru

```
HTTP/2 405
allow: GET, HEAD
date: Sun, 22 Sep 2019 17:11:16 GMT
content-type: text/html; charset=UTF-8
server: gws
content-length: 1592
x-xss-protection: 0
x-frame-options: SAMEORIGIN
alt-svc: quic=":443"; ma=2592000; v="46,43,39"
```

`https://github.com/`

OPTIONS  HTTP/1.1

Host: github.com
```
HTTP/1.1 404 Not Found
Date: Sun, 22 Sep 2019 17:14:28 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 0
Server: GitHub.com
Status: 404 Not Found
X-Request-Id: ecf63e95-6e9a-4112-bd8b-4f3155182e01
Strict-Transport-Security: max-age=31536000; includeSubdomains; preload
X-Frame-Options: deny
X-Content-Type-Options: nosniff
```

`https://www.apple.com/` 

OPTIONS  HTTP/1.1
Host: www.apple.com

Получен заголовок Allow (200OK).

```
HTTP/2 200
server: Apache
content-length: 0
content-type: text/html; charset=UTF-8
set-cookie: geo=RU; path=/; domain=.apple.com
set-cookie: ccl=w2vRaBfBa2yQjU9wGsdfsdfsQ==; path=/; domain=.apple.com
x-frame-options: SAMEORIGIN
strict-transport-security: max-age=31536000; includeSubDomains
x-content-type-options: nosniff
allow: GET,HEAD,POST,OPTIONS
x-xss-protection: 1; mode=block
cache-control: max-age=274
expires: Sun, 22 Sep 2019 17:19:38 GMT
date: Sun, 22 Sep 2019 17:14:28 GMT
```

**Отправленный запрос OPTIONS был верно обработан только лишь сайтами  https://www.google.ru и https://www.apple.com/. 
Ответы на запрос OPTIONS содержали заголовок Allow, который определял доступные HTTP-методы.**


## Запрос HEAD 

Запрос  HEAD  - запрашивает заголовки, идентичные тем, что возвращаются, если указанный ресурс будет запрошен с помощью HTTP-метода GET. Такой запрос может быть выполнен перед загрузкой большого ресурса, например, для экономии пропускной способности.
Ответ на метод HEAD не должен содержать тело. Если это не так, то его следует игнорировать. 


`https://vk.com`
HEAD-запрос

HEAD  HTTP/1.1
Host: vk.com

```
HTTP/1.1 418
Server: VK
Date: Sun, 22 Sep 2019 17:27:03 GMT
Content-Length: 0
Connection: keep-alive
X-Frontend: front204303
Access-Control-Expose-Headers: X-Frontend

```

Вернул код 418 и сообщение "I'm a teapot (RFC 2324)". 



`https://www.apple.com` - 200 OK
HEAD-запрос

HEAD  HTTP/1.1
Host: www.apple.com

```
HTTP/2 200
server: Apache
x-frame-options: SAMEORIGIN
x-xss-protection: 1; mode=block
accept-ranges: bytes
x-content-type-options: nosniff
content-type: text/html; charset=UTF-8
strict-transport-security: max-age=31536000; includeSubDomains
content-length: 61591
cache-control: max-age=429
expires: Sun, 22 Sep 2019 17:40:00 GMT
date: Sun, 22 Sep 2019 17:31:32 GMT
set-cookie: geo=RU; path=/; domain=.apple.com
set-cookie: ccl=GRP0ypMJcewrEG2W/Jsdsew==; path=/; domain=.apple.com
```

`http://www.msn.com/ru-ru/` 200 OK
HEAD-запрос

HEAD / HTTP/1.1
Host: www.msn.com


```
HTTP/1.1 200 OK
Cache-Control: no-cache, no-store, no-transform
Pragma: no-cache
Content-Length: 55741
Content-Type: text/html; charset=utf-8
Expires: -1
Vary: User-Agent
Set-Cookie: PreferencesMsn=eyJFeHBdfsdfkYUREIURdfsdTMxNzg3MjksIlZlcnNpb24iOjF90; domain=msn.com; expires=Sun, 20-Sep-2020 13:34:25 GMT; path=/; HttpOnly
Set-Cookie: anoncknm=; domain=msn.com; path=/; HttpOnly
Access-Control-Allow-Origin: *
X-AspNetMvc-Version: 5.2
X-AppVersion: 20190918_18351996
X-Activity-Id: 8867b1f0-8496-4430-b010-32610485ba80
X-Az: {did:b24a0ea2b3ba45a59fc1d4d299c5ebc1, rid: 61, sn: neurope-prod-hp, dt: 2019-09-22T07:10:37.7802268Z, bt: 2019-09-20T19:42:51.7426325Z}
X-UA-Compatible: IE=Edge;chrome=1
X-Content-Type-Options: nosniff
X-FRAME-OPTIONS: SAMEORIGIN
X-Powered-By: ASP.NET
Access-Control-Allow-Methods: HEAD,GET,OPTIONS
X-XSS-Protection: 1
X-MSEdge-Ref: Ref A: 8867B1F084964430B01032610485BA80 Ref B: WAW01EDGE0310 Ref C: 2019-09-20T13:34:25Z
Set-Cookie: _EDGE_S=F=1; path=/; httponly; domain=msn.com
Set-Cookie: _EDGE_V=1; path=/; httponly; expires=Wed, 14-Oct-2020 13:34:25 GMT; domain=msn.com
Set-Cookie: MUID=339404AAFDHSJDJHS67B7118C80977F4B46A0E; path=/; expires=Wed, 14-Oct-2020 13:34:25 GMT; domain=msn.com
Date: Sun, 22 Sep 2019 17:34:51 GMT
```

**На запрос HEAD прислали ожидаемый ответ сайты www.apple.com, 
www.msn.com. Действительно запрашиваемые заголовки были идентичны тем, что возвращаются, если указанный ресурс будет запрошен с помощью HTTP-метода GET.**

## Запросы GET и POST

GET запрашивает представление указанного ресурса. GET-запросы должны только получать данные. (запрос не имеет тело)


POST предназначен для отправки данных на сервер (например, отправка формы). Тип тела запроса указывается в заголовке Content-Type.

`https://yandex.ru`

GET / HTTP/1.1
Host: yandex.ru

```

HTTP/2 200
content-length: 177790
content-security-policy: object-src https://avatars.mds.yandex.net;frame-src https://mc.yandex.ru https://yastatic.net 'self' https://yandex.ru;script-src https://yandex.ru 'self' https://yastatic.net https://mc.yandex.ru 'unsafe-inline';style-src 'unsafe-inline' https://yastatic.net;img-src https://leonardo.edadeal.io https://favicon.yandex.net https://awaps.yandex.net data: 'self' https://yandex.ru https://mc.yandex.ru https://avatars.mds.yandex.net https://yabs.yandex.ru https://strm.yandex.ru https://mc.admetrica.ru https://*.strm.yandex.net https://resize.yandex.net https://yastatic.net;default-src https://yastat.net https://yastatic.net;font-src https://yastatic.net;connect-src https://mc.admetrica.ru https://games.yandex.ru https://yastatic.net wss://portal-xiva.yandex.net https://api.market.yandex.ru https://mc.yandex.ru https://yastat.net https://portal-xiva.yandex.net https://mobile.yandex.net https://yandex.ru 'self' https://zen.yandex.ru;report-uri https://csp.yandex.net/csp?project=morda&from=morda.big.ru&showid=1568987431.48934.141248.4397&h=man2-5786-7ff-man-portal-morda-29675&csp=new&date=20190920&yandexuid=5283215881568987431
date: Fri, 20 Sep 2019 13:50:31 GMT
x-content-type-options: nosniff
set-cookie: yp=1571579431.ygu.1; Expires=Mon, 17-Sep-2029 13:50:31 GMT; Domain=.yandex.ru; Path=/
set-cookie: mda=0; Expires=Sat, 18-Jan-2020 13:50:31 GMT; Domain=.yandex.ru; Path=/
set-cookie: yandex_gid=213; Expires=Sun, 20-Oct-2019 13:50:31 GMT; Domain=.yandex.ru; Path=/
set-cookie: yandexuid=5283215881568987431; Expires=Mon, 17-Sep-2029 13:50:31 GMT; Domain=.yandex.ru; Path=/
set-cookie: i=dNgLj7xjsdfde3wd57Cv+n+9pdm/VhRYnBxWiseJDMgbYgGAM1Grh/MlAtXRvIwGXQzUijP5WBYt+sBthdqWZsZJ1nI=; Expires=Mon, 17-Sep-2029 13:50:31 GMT; Domain=.yandex.ru; Path=/; Secure; HttpOnly
x-frame-options: DENY
expires: Sun, 22 Sep 2019 17:36:11 GMT
p3p: policyref="/w3c/p3p.xml", CP="NON DSP ADM DEV PSD IVDo OUR IND STP PHY PRE NAV UNI"
last-modified: Sun, 22 Sep 2019 17:36:11 GMT
cache-control: no-cache,no-store,max-age=0,must-revalidate
content-type: text/html; charset=UTF-8

```
Content-Type в HTML форме


POST / HTTP/1.1
Host: yandex.ru


```
HTTP/2 403
content-length: 12407
etag: "5d83b8d2-3077"
content-type: text/html; charset=utf-8
date: Fri, 20 Sep 2019 13:58:44 GMT
x-content-type-options: nosniff
set-cookie: i=sA8o6K7+WifPDh8FiPHdrplT9W/MMC9dgh6JL07yjjBRJycTTAo95TxBrVTU9DfC1EAw1dtQn3NeRKCBFQxZmduYxBc=; Expires=Mon, 17-Sep-2029 13:58:44 GMT; Domain=.yandex.ru; Path=/; Secure; HttpOnly

```
403 (сервер понял запрос, но отказывается его авторизовать)

`https://www.google.com`

GET / HTTP/1.1
Host: google.com 


```
HTTP/2 200
date: Fri, 20 Sep 2019 14:01:37 GMT
expires: -1
cache-control: private, max-age=0
content-type: text/html; charset=ISO-8859-1
p3p: CP="This is not a P3P policy! See g.co/p3phelp for more info."
server: gws
x-xss-protection: 0
x-frame-options: SAMEORIGIN
set-cookie: 1P_JAR=2019-09-20-14; expires=Sun, 20-Oct-2019 14:06:02 GMT; path=/; domain=.google.com; SameSite=none
set-cookie: NID=188=MFy5QIqghaJFMcXDEFIudjfhdjshr4433489rtermPa9s3Ka5WqyRsWy_5LhTuVWNr7XoWdHZQCoa-YcEcdzKK_Hc7B272UHkkmrZB9SSDGSHDGYERDKSfsdfsdfdsfiPXfKu71MzpC8; expires=Sat, 21-Mar-2020 14:06:02 GMT; path=/; domain=.google.com; HttpOnly
alt-svc: quic=":443"; ma=2592000; v="46,43,39"
accept-ranges: none
vary: Accept-Encoding
```

POST / HTTP/1.1
Host: google.com 

```
HTTP/2 405
allow: GET, HEAD
date: Fri, 20 Sep 2019 14:15:25 GMT
content-type: text/html; charset=UTF-8
server: gws
content-length: 1589
x-xss-protection: 0
x-frame-options: SAMEORIGIN
alt-svc: quic=":443"; ma=2592000; v="46,43,39"
```

405 (метод запроса известен серверу, но был отключен и не может быть использован).

`https://www.apple.com`


GET / HTTP/1.1
Host: apple.com

```
HTTP/2 200
server: Apache
content-length: 61591
content-type: text/html; charset=UTF-8
set-cookie: geo=RU; path=/; domain=.apple.com
set-cookie: ccl=J+CQc9W/bZYERQ4y9kKisg==; path=/; domain=.apple.com
etag: dfsjdfh"23432909"\sdf
strict-transport-security: max-age=31536000; includeSubDomains
x-content-type-options: nosniff
x-xss-protection: 1; mode=block
x-frame-options: SAMEORIGIN
cache-control: max-age=0
expires: Fri, 20 Sep 2019 14:18:04 GMT
date: Fri, 20 Sep 2019 14:18:04 GMT
```


POST / HTTP/1.1
Host: apple.com
Context-Type не указан

```
HTTP/2 411
server: AkamaiGHost
mime-version: 1.0
content-type: text/html
content-length: 223
cache-control: max-age=0
expires:  Fri, 20 Sep 2019 14:18:33 GMT
date:  Fri, 20 Sep 2019 14:18:39 GMT
set-cookie: geo=RU; path=/; domain=.apple.com
set-cookie: ccl=chD+NG11VCo+to26kNeRMw==; path=/; domain=.apple.com
```


**GET-запрос во всех случаях возвращает веб-страницу соответствующего ресурса. POST-запрос возвращает 4хх ошибку, кроме веб-ресурса apple.com.**


## Работа с VK Api

### Вернуть список всех факультетов МГТУ им. Н. Э. Баумана

C помощью vk devtools находим id города (тк МГТУ есть не только в Москве) и id университета. Используем метод `database.getUniversities` 

ID города Москва - `city_id = 1` (метод `database.getCities`)

`q = МГТУ им. Н. Э. Баумана`

Результат : 

```
{
"response": {
"count": 2,
"items": [{
"id": 250,
"title": "МГТУ им. Н. Э. Баумана"
}, {
"id": 169759,
"title": "ИСОТ МГТУ им. Н. Э. Баумана (бывш. МИПК МГТУ им. Н. Э. Баумана)"
}]
}
}
```

Получаем, что `university_id = 250`

Используя `database.getFaculties` и зная `university_id` выведем список всех факультетов.

Результат:

```
{
"response": {
"count": 20,
"items": [{
"id": 1031,
"title": "Аэрокосмический факультет"
}, {
"id": 1032,
"title": "Факультет инженерного бизнеса и менеджмента"
}, {
"id": 1033,
"title": "Факультет информатики и систем управления"
}, {
"id": 1034,
"title": "Факультет машиностроительных технологий"
}, {
"id": 1035,
"title": "Факультет оптико-электронного приборостроения"
}, {
"id": 1036,
"title": "Приборостроительный факультет"
}, {
"id": 1037,
"title": "Радиотехнический факультет"
}, {
"id": 1038,
"title": "Факультет радиоэлектроники и лазерной техники"
}, {
"id": 1039,
"title": "Факультет ракетно-космической техники"
}, {
"id": 1040,
"title": "Факультет робототехники и комплексной автоматизации"
}, {
"id": 1041,
"title": "Факультет специального машиностроения"
}, {
"id": 1042,
"title": "Факультет фундаментальных наук"
}, {
"id": 1043,
"title": "Факультет энергомашиностроения"
}, {
"id": 1044,
"title": "Кафедра юриспруденции, интеллектуальной собственности и судебной экспертизы"
}, {
"id": 1803,
"title": "Факультет биомедицинской техники"
}, {
"id": 1804,
"title": "Факультет социально-гуманитарных наук"
}, {
"id": 56430,
"title": "Факультет лингвистики"
}, {
"id": 56431,
"title": "Физкультурно-оздоровительный факультет"
}, {
"id": 2071503,
"title": "Головной учебно-исследовательский и методический центр (ГУИМЦ)"
}, {
"id": 2183736,
"title": "Факультет военного обучения (Военный институт)"
}]
}
}
```
### Получить свою аватарку

```
{
"response": [{
"id": 137452709,
"first_name": "Marianna",
"last_name": "Yakubauskaite",
"is_closed": false,
"can_access_closed": true,
"photo_50": "https://sun9-35.u...kKZRtoy18.jpg?ava=1",
"verified": 0
}]
}
```

Возращает ссылку на фото в хранилище.

Api vk при соблюдении условий передачи обязательных данных вместе с запросом, таких как access_token для авторизации запроса, сервер отвечает кодом состояния 200 (ОК).
В заголовках передается content-type: application/json; charset=utf-8. Тело ответа представляет собой json файл в кодировке utf-8. server: VK версия протокола HTTP/2 200.

### Отправить пост
Для отправки поста на стену пользователя или сообщества используется метод wall.post

Корректно отработанный метод возвращает json file, содержащий идентификатор отправленного поста. 
Для того, чтобы отправить пост другу/сообществу необходимо знать owner_id

```
{
    "response": {
        "post_id": 2341
    }
}

```

**В POST запросе параметры хранятся в теле запроса и могут быть представлены в разном виде. 
В отличие от GET запроса размер передаваемых данных не ограничивается длиной адресной строки браузера.  
Метод POST скрывает все передаваемые ему переменные и значения в теле (метод GET хранит их в строке запроса).**

