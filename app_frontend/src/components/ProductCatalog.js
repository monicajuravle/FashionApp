import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/ProductCatalog.css";

const ProductCatalog = () => {
    const [products, setProducts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetch("http://localhost:8080/api/produs/allProducts")
            .then((response) => response.json())
            .then((data) => {
                console.log("Produse primite:", data); // Pentru debugging
                setProducts(data);
            })
            .catch((error) => console.error("Eroare la preluarea produselor:", error));
    }, []);


    const handleAddProduct = () => {
        navigate("addProduct");
    };

    return (
        <div className="product-catalog">
            <h2>Catalog Produse</h2>
            <button className="add-product-button" onClick={handleAddProduct}>
                Adaugă Produs
            </button>
            <div className="product-list">
                {products.length > 0 ? (
                    products.map((product) => (
                        <div key={product.idProdus} className="product-card">
                            <h3>{product.numeProdus}</h3>
                            <p>Descriere: {product.descriere}</p>
                            <p>Preț: {product.pret} RON</p>
                            <p>
                                <a href={product.urlProvenienta} target="_blank" rel="noopener noreferrer">
                                    Vizitează sursa
                                </a>
                            </p>
                        </div>
                    ))
                ) : (
                    <p>Nu există produse în catalog.</p>
                )}
            </div>

        </div>
    );
};

export default ProductCatalog;
