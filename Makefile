
start:
	@echo "initializing docker containers in inventory service..."
	@docker-compose -f inventory-service/docker-compose.yaml up -d

	@echo "initializing docker containers product service..."
	@docker-compose -f product-service/docker-compose.yaml up -d

	@echo "initializing docker containers in order service..."
	@docker-compose -f order-service/docker-compose.yaml up -d

	@echo "Containers successfully deployed"

stop:
	@echo "Stopping containers in inventory service..."
	@docker-compose -f inventory-service/docker-compose.yaml down

	@echo "Stopping containers in product service..."
	@docker-compose -f product-service/docker-compose.yaml down

	@echo "Stopping containers in order service..."
	@docker-compose -f order-service/docker-compose.yaml down

	@echo "Containers successfully destroyed"