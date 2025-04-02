import React from "react";
import ReactDOM from "react-dom/client";  // Asigură-te că folosești 'react-dom/client' în React 18
import App from "./App";
import "./index.css"; // dacă folosești un fișier de stil global

// Crează root-ul și renderizează aplicația
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);
