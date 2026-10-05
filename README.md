{
  "realm": "meu-primeiro-springboot",
  "enabled": true,
  "displayName": "Meu Primeiro Spring Boot",
  "roles": {
    "realm": [
      {
        "name": "USER",
        "description": "Usuário comum da API"
      },
      {
        "name": "ADMIN",
        "description": "Administrador da API"
      }
    ]
  },
  "clients": [
    {
      "clientId": "meu-primeiro-springboot-api",
      "name": "Meu Primeiro Spring Boot API",
      "enabled": true,
      "protocol": "openid-connect",
      "publicClient": true,
      "directAccessGrantsEnabled": true
    }
  ],
  "users": [
    {
      "username": "kayke",
      "enabled": true,
      "firstName": "Kayke",
      "lastName": "Vieira",
      "credentials": [
        {
          "type": "password",
          "value": "123456",
          "temporary": false
        }
      ],
      "realmRoles": [
        "USER"
      ]
    }
  ]
}
