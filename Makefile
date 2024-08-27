.PHONY: db
db:
	@echo "Creating database..."
	docker run \
      --name legacy-db \
      -d \
      -p 5432:5432 \
      -e POSTGRES_USER=mark \
      -e POSTGRES_PASSWORD=ruler \
      -e POSTGRES_DB=legacy \
      postgres:11.22-bullseye
	@echo "Database created."

.PHONY: redis
redis:
	@echo "Creating redis..."
	docker run \
	  --name=redis-local \
	  -d \
	  -p 6379:6379 \
	  --restart=always \
	  redis:5.0.13
	@echo "Redis created."
