import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const OccasionOutfit = () => {
    const { occasion } = useParams();
    const [produse, setProduse] = useState([]);
    const [loading, setLoading] = useState(true);
    const [message, setMessage] = useState(""); // Mesajul de succes sau eroare
    const [idUtilizator, setUtilizator] = useState(null);

    // Presupunem că ID-ul utilizatorului este stocat în localStorage
    useEffect(() => {
        // Retrieve data from localStorage
        const utilizator = localStorage.getItem('idUtilizator');
        console.log("Current idUtilizator state:", utilizator);

        if (utilizator) {
            console.log("id correct");
            console.log(utilizator);
            setUtilizator(utilizator); // Parse the data if available
        }
    }, []);

    // Funcția pentru a adăuga produsul în coș
    const addToCart = async (id_produs) => {
        try {
            console.log(id_produs);
            const response = await fetch("http://localhost:8080/api/cos/adauga", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    idProdus:id_produs,
                    idUtilizator: idUtilizator
                }),
            });

            //const data = await response.json();
            console.log( "Produsul a fost adăugat cu succes.");
        } catch (error) {
            console.error("Eroare la adăugarea produsului:", error);
        }
    };


    // Funcție pentru a aduce produsele din backend
    const fetchProduse = async () => {
        try {
            console.log("exists:",idUtilizator);
            const response = await fetch(`http://localhost:8080/api/produs/ocazie/${occasion}/${idUtilizator}`);
            const data = await response.json();
            setProduse(data);
            setLoading(false);
        } catch (error) {
            console.error("Error fetching products:", error);
            setLoading(false);
        }
    };

    // UseEffect pentru a aduna produsele când se schimbă ocazia
    useEffect(() => {
        if(idUtilizator!=null)
        {
            fetchProduse();
        }
    }, [occasion,idUtilizator]);

    return (
        <div>
            <h1>Produse pentru ocazia: {occasion}</h1>
            {loading ? (
                <p>Se încarcă...</p>
            ) : (
                <div className="product-list">
                    {produse.length > 0 ? (
                        produse.map((produs) => (
                            <div key={produs.idProdus} className="product-item">
                                <img
                                    src={`http://localhost:8080/uploads/${produs.imagine}`}
                                    alt={produs.numeProdus}
                                    style={{ width: "200px", height: "auto" }}
                                />
                                <h3>{produs.numeProdus}</h3>
                                <p>{produs.descriere}</p>
                                <p>Pret: {produs.pret} RON</p>

                                <button onClick={() => addToCart(produs.idProdus)}>
                                    Adaugă în coș
                                </button>
                            </div>
                        ))
                    ) : (
                        <p>Nu sunt produse pentru această ocazie.</p>
                    )}
                </div>
            )}
            {message && <p>{message}</p>} {/* Afișează mesajul de succes sau eroare */}
        </div>
    );
};

export default OccasionOutfit;
