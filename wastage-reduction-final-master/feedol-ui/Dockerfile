FROM node:12

WORKDIR /app

COPY . .

RUN npm install

RUN npm install http-server -g

RUN npm run build

WORKDIR  /app/dist/Wastage

ENTRYPOINT ["http-server", "-c1", "-p", "4200"]

