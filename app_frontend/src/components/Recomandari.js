import React, { useEffect, useState } from "react";
import "../styles/Recomandari.css"; // Vom crea un fișier CSS pentru stilizare

const Recomandari = () => {
    const [productsMeeting, setProductsMeeting] = useState([]);
    const [productsOffice, setProductsOffice] = useState([]);
    const [productsCasual, setProductsCasual] = useState([]);
    const [productsWedding, setProductsWedding] = useState([]);

    useEffect(() => {
        // Funcție de a obține produsele pentru fiecare ocazie
        const fetchProductsByOccasion = async (ocazie) => {
            const response = await fetch(`http://localhost:8080/api/produs/ocazie/${ocazie}`);
            return await response.json();
        };

        // Încărcarea produselor pe baza ocaziei
        const loadProducts = async () => {
            setProductsMeeting(await fetchProductsByOccasion("Intalnire"));
            setProductsOffice(await fetchProductsByOccasion("Birou"));
            setProductsCasual(await fetchProductsByOccasion("Casual"));
            setProductsWedding(await fetchProductsByOccasion("Nunta"));
        };

        loadProducts();
    }, []);

    // Funcția pentru a afișa produsele într-o secțiune
    const renderProducts = (products) => {
        return products.length > 0 ? (
            products.map((product) => (
                <div key={product.idProdus} className="product-card">
                    <h3>{product.numeProdus}</h3>
                    <p>{product.descriere}</p>
                    <p>Preț: {product.pret} RON</p>
                </div>
            ))
        ) : (
            <p>Nu există produse pentru această ocazie.</p>
        );
    };

    return (
        <div className="recomandari-container">
            <div className="ocazie-section">
                <h2>Intâlnire</h2>
                <div className="product-list">{renderProducts(productsMeeting)}</div>
            </div>
            <div className="ocazie-section">
                <h2>Birou</h2>
                <div className="product-list">{renderProducts(productsOffice)}</div>
            </div>
            <div className="ocazie-section">
                <h2>Casual</h2>
                <div className="product-list">{renderProducts(productsCasual)}</div>
            </div>
            <div className="ocazie-section">
                <h2>Nuntă</h2>
                <div className="product-list">{renderProducts(productsWedding)}</div>
            </div>
        </div>
    );
};

export default Recomandari;
