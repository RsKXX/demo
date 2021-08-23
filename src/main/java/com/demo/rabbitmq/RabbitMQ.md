docker 启动rabbitmq

``docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management
``

配置rabbitmq 用户 virtualHosts