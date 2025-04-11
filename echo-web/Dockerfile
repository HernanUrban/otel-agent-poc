FROM openjdk:21-jdk-slim-buster
ARG JAR_FILE=target/*\.jar
COPY ${JAR_FILE} app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.30.0/opentelemetry-javaagent.jar /opt/opentelemetry-agent.jar
ENV JAVA_TOOL_OPTIONS="-XX:-UseContainerSupport"
ENV ENVIRONMENT=production
ENV OTEL_TRACES_SAMPLER=always_on
ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=otlp
ENV OTEL_LOGS_EXPORTER=otlp
ENV OTEL_EXPORTER_OTLP_PROTOCOL=grpc
ENV OTEL_SERVICE_NAME=echo-web
ENV OTEL_PROPAGATORS=tracecontext,baggage,
ENV OTEL_LOGS_ATTRIBUTE_ALLOW_LIST=service.name,service.instance.id,environment

ENTRYPOINT java -javaagent:/opt/opentelemetry-agent.jar \
        -Dotel.resource.attributes="service.name=${OTEL_SERVICE_NAME},service.instance.id=$HOSTNAME,environment=${ENVIRONMENT}" \
    -jar /app.jar
