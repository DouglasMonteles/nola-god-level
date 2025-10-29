# Etapa de build
FROM node:22-alpine AS build

WORKDIR /frontend
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build


FROM nginx:1.28.0-alpine-slim

RUN apk update && apk upgrade --no-cache

COPY --from=build /frontend/dist/frontend/browser /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
