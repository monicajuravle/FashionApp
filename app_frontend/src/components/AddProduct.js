import React, { useState } from "react";

const AddProduct = () => {
    const [descriere, setDescriere] = useState("");
    const [imagine, setImagine] = useState(null);
    const [numeProdus, setNumeProdus] = useState("");
    const [pret, setPret] = useState("");
    const [urlProvenienta, setUrlProvenienta] = useState("");
    const [ocazie, setOcazie] = useState("");
    const [culoare, setCuloare] = useState("");


    const handleSubmit = async (e) => {
        e.preventDefault();

        // Verificăm dacă imaginea a fost selectată
        if (!imagine) {
            alert("Te rog selectează o imagine.");
            return;
        }

        // Creăm un obiect FormData
        const formData = new FormData();

        formData.append("descriere", descriere);
        formData.append("numeProdus", numeProdus);
        formData.append("imagine", imagine);
        formData.append("pret", parseFloat(pret));
        formData.append("urlProvenienta", urlProvenienta);
        formData.append("ocazie", ocazie);
        formData.append("culoare", culoare);


        try {
            // Trimitem formularul la server
            const response = await fetch("http://localhost:8080/api/produs/adaugare", {
                method: "POST",
                body: formData, // FormData va trimite fișierul și datele
            });

            // Verificăm răspunsul de la server
            if (response.ok) {
                alert("Produs adăugat cu succes!");
                // Resetăm formularul după succes
                setNumeProdus("");
                setDescriere("");
                setPret("");
                setUrlProvenienta("");
                setImagine(null);
                setOcazie("");
                setCuloare("");
            } else {
                alert("Eroare la adăugarea produsului.");
            }

        } catch (error) {
            console.error("Eroare:", error);
            alert("A apărut o eroare la trimiterea formularului.");
        }
    };

    return (
        <form onSubmit={handleSubmit} encType="multipart/form-data">
            <label htmlFor="numeProdus">Nume Produs:</label>
            <input
                type="text"
                id="numeProdus"
                value={numeProdus}
                onChange={(e) => setNumeProdus(e.target.value)}
                required
            /><br />

            <label htmlFor="descriere">Descriere:</label>
            <input
                type="text"
                id="descriere"
                value={descriere}
                onChange={(e) => setDescriere(e.target.value)}
                required
            /><br />

            <label htmlFor="pret">Preț:</label>
            <input
                type="number"
                id="pret"
                value={pret}
                onChange={(e) => setPret(e.target.value)}
                required
            /><br />

            <label htmlFor="urlProvenienta">URL Proveniență:</label>
            <input
                type="url"
                id="urlProvenienta"
                value={urlProvenienta}
                onChange={(e) => setUrlProvenienta(e.target.value)}
                required
            /><br />

            <label htmlFor="imagine">Imagine:</label>
            <input
                type="file"
                id="imagine"
                onChange={(e) => setImagine(e.target.files[0])}
                required
            /><br />

           < div>
            <label htmlFor="ocazie">Ocazie:</label>
            <input
                type="text"
                id="ocazie"
                value={ocazie}
                onChange={(e) => setOcazie(e.target.value)}
            />
        </div>
            <div>
                <label>Culoare</label>
                <input
                    type="text"
                    value={culoare}
                    onChange={(e) => setCuloare(e.target.value)}
                    required
                />
            </div>

            <button type="submit">Adaugă Produs</button>
        </form>
    );
};

export default AddProduct;

