FROM node:20-alpine

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

EXPOSE 5173

CMD ["sh", "-c", "npm install && npm run start -- --host 0.0.0.0 --port 5173 --poll 2000"]
