FROM grafana/alloy:v1.7.2

#Base environment variables declaration
ARG GRAFANA_CLOUD_PROMETHEUS_URL=https://prometheus-prod-10-prod-us-central-0.grafana.net/api/prom
ARG GRAFANA_CLOUD_PROMETHEUS_USERNAME=493818
ARG GRAFANA_CLOUD_API_KEY=secret
ARG GRAFANA_CLOUD_LOKI_URL=https://logs-prod3.grafana.net/loki/api/v1/push    
ARG GRAFANA_CLOUD_LOKI_USERNAME=245879
ARG GRAFANA_CLOUD_TEMPO_ENDPOINT=https://tempo-us-central1.grafana.net
ARG GRAFANA_CLOUD_TEMPO_USERNAME=242391

#Actual dynamic environment variables declaration
ENV GRAFANA_CLOUD_PROMETHEUS_URL=$GRAFANA_CLOUD_PROMETHEUS_URL     
ENV GRAFANA_CLOUD_PROMETHEUS_USERNAME=$GRAFANA_CLOUD_PROMETHEUS_USERNAME
ENV GRAFANA_CLOUD_API_KEY=$GRAFANA_CLOUD_API_KEY
ENV GRAFANA_CLOUD_LOKI_URL=$GRAFANA_CLOUD_LOKI_URL           
ENV GRAFANA_CLOUD_LOKI_USERNAME=$GRAFANA_CLOUD_LOKI_USERNAME      
ENV GRAFANA_CLOUD_TEMPO_ENDPOINT=$GRAFANA_CLOUD_TEMPO_ENDPOINT     
ENV GRAFANA_CLOUD_TEMPO_USERNAME=$GRAFANA_CLOUD_TEMPO_USERNAME     

COPY --chmod=777 ./config.alloy /etc/alloy/config.alloy

CMD ["run","--server.http.listen-addr=0.0.0.0:12345","/etc/alloy/config.alloy"]

