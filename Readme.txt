Document demo Docker network, Docker storage and Shell (send mail)

- Demo Docker network
	+ bridge: Create 2 container A1, A2 with driver bridge. Ping A1 to google.com and ping A1 to A2
	+ host: Create container B1 and ping B1 to google.com, ping B1 to A2
	+ none: Create container C1 and ping C1 to google.com, ping C1 to A1, and ping C1 to B1
- Demo Docker Storage
	+ Volume
	+ Bind mounts
- Demo shell
	+ User crontab send mail at every minute with file .sh 
	+ User crontab send mail at every minute with file .jar
- Demo run docker compose
	+ từ file docker-compose.yml run 2 container một container chứa web java, một bên là mysql 
-- -----------------------------------------------------------
Demo shell
- Config file: /etc/ssmtp/ssmtp.conf
	
UseSTARTTLS=YES
FromLineOverride=YES
root=admin@example.com
mailhub=smtp.gmail.com:587
AuthUser=nickname96bn@gmail.com
AuthPass=0904955121aA@