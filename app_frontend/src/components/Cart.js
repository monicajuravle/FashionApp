import React, { useEffect, useState } from "react";
import "../styles/Cart.css"

const Cart = () => {
    const [cartProducts, setCartProducts] = useState([]);
    const userId = localStorage.getItem("idUtilizator"); // Presupunem că id-ul utilizatorului este stocat în localStorage

    useEffect(() => {
        // Fetch produsele din coș
        fetch(`http://localhost:8080/api/cart/${userId}`)
            .then((response) => response.json())
            .then((data) => setCartProducts(data))
            .catch((error) => console.error("Error fetching cart products:", error));
    }, [userId]);

    return (
        <div className="cart-container">
            <h2>Produse în coș</h2>
            {cartProducts.length > 0 ? (
                cartProducts.map((product) => (
                    <div key={product.idProdus} className="product-card">
                        <h3>{product.numeProdus}</h3>
                        <p>{product.descriere}</p>
                        <p>Preț: {product.pret} RON</p>
                    </div>
                ))
            ) : (
                <p>Coșul este gol.</p>
            )}
        </div>
    );
};

export default Cart;
