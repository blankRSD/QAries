> docker pull postgres

> docker run --name postgres-sapient1 -p 5432:5432 -v /Users/naveenkumar/Desktop/postgres-db:/var/lib/postgresql/data -e POSTGRES_PASSWORD=kanchan -d postgres

> docker cp abc.sql <container Id>:/abc.sql   //upload sql file to docker container

> docker exec -it < containerid > psql -U postgres 

> pg_restore -U postgres -f abc.sql





> 