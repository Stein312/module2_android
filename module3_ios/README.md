Открывайте файл [Homework3.xcworkspace](Homework3.xcworkspace), чтобы все зависимости проекта установленные через **Cocoapods** работали должным образом.

# Foursquare API

Данные для авторизации с **Foursquare API** ([инструкция](https://developer.foursquare.com/docs/api/configuration/authentication)):
* **Client ID**: *JLMXOP3VWT5E3WKUWG1MRD1OLTX0VNX1J5SLV205U3GAFVSS*
* **Client Secret**: *RDVGOPEJDXGMPZUESRFU3JT0IIY5NGX4CBFT0X1W3J4TNNCW*

Пример запроса к **Foursquare API** (посмотреть ответ можно также, открыв данную ссылку в браузере):

```bash
#!/bin/bash
curl https://api.foursquare.com/v2/venues/explore?ll=55.764891,37.615425&section=coffee&client_id=JLMXOP3VWT5E3WKUWG1MRD1OLTX0VNX1J5SLV205U3GAFVSS&client_secret=RDVGOPEJDXGMPZUESRFU3JT0IIY5NGX4CBFT0X1W3J4TNNCW&v=20180630
```
