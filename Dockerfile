# 1. Initialize a parent image
FROM maven:3.6.3-openjdk-11
LABEL maintainer="Nikolai Osipov <nao99.dev@gmail.com>"

# 2. Copy project files into application directory in container
COPY src /app/src
COPY pom.xml /app
COPY entrypoint.sh /app

# 3. Set an application work directory
WORKDIR /app

# 4. Add executable privileges for entrypoint script
RUN chmod +x entrypoint.sh

# 5. Build and start the application
ENTRYPOINT ["/app/entrypoint.sh"]
