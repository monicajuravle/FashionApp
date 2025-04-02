import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/UpdateProfile.css";

const UpdateProfile = () => {
    const navigate = useNavigate();

    // State pentru datele de profil
    const [nume, setNume] = useState("");
    const [prenume, setPrenume] = useState("");
    const [email, setEmail] = useState("");
    const [parola, setParola] = useState("");
    const [inaltime, setInaltime] = useState("");
    const [greutate, setGreutate] = useState("");
    const [culoriPreferate, setCuloriPreferate] = useState([]);
    const [toateCulorile, setToateCulorile] = useState([]); // Culorile disponibile
    const [idUtilizator, setUtilizator] = useState(null);

    useEffect(() => {
        // Retrieve data from localStorage
        const utilizator = localStorage.getItem('idUtilizator');

        if (utilizator) {
            setUtilizator(utilizator); // Parse the data if available
        }
    }, []);

    useEffect(() => {
        if(idUtilizator) {
            // Exemplu de preluare a datelor din baza de date (API)
            // Într-un proiect real, ai utiliza un API pentru a adresa această cerere
            fetch(`http://localhost:8080/api/utilizatori/get-user-profile/${idUtilizator}`)
                .then((response) => response.json())
                .then((data) => {

                    setNume(data.nume); // Direct field in Utilizator
                    setPrenume(data.prenume); // Direct field in Utilizator
                    setEmail(data.email); // Direct field in Utilizator
                    setParola(data.parola); // Do not set the password
                    setInaltime(data.inaltime);
                    setGreutate(data.greutate);
                })
        }
    }, [idUtilizator]);

    const handleUpdatePersonal = async (e) => {
        e.preventDefault();
        // Trimite datele modificate ale secțiunii personale către server
        const personalData = {idUtilizator, nume, prenume, email, parola,active:false };
        console.log("correct",personalData.idUtilizator);
        fetch("http://localhost:8080/api/utilizatori/update-personal-data", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(personalData),
        })
            .then((response) => {
                if (response.ok) {
                    alert("Informațiile personale au fost actualizate!");
                } else {
                    alert("A apărut o eroare.");
                }
            })
            .catch((error) => console.error("Error updating data: ", error));
    };

    const handleUpdateProfile = async (e) => {
        e.preventDefault();
        // Trimite datele modificate ale secțiunii de profil (inaltime, greutate, culori preferate)
        const profileData = { inaltime, greutate, culoriPreferate };

        fetch("/api/update-profile-info", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(profileData),
        })
            .then((response) => {
                if (response.ok) {
                    alert("Informațiile de profil au fost actualizate!");
                } else {
                    alert("A apărut o eroare.");
                }
            })
            .catch((error) => console.error("Error updating data: ", error));
    };

    return (
        <div className="update-profile-container">
            <h1>Actualizare Profil</h1>
            <form>
                <div className="update-profile-content">
                    <div className="update-left">
                        <h2>Informații Personale</h2>
                        <div className="input-field">
                            <label htmlFor="nume">Nume:</label>
                            <input
                                type="text"
                                id="nume"
                                value={nume}
                                onChange={(e) => setNume(e.target.value)}
                                required
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor="prenume">Prenume:</label>
                            <input
                                type="text"
                                id="prenume"
                                value={prenume}
                                onChange={(e) => setPrenume(e.target.value)}
                                required
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor="email">Email:</label>
                            <input
                                type="email"
                                id="email"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                required
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor="parola">Parola:</label>
                            <input
                                type="password"
                                id="parola"
                                value={parola}
                                onChange={(e) => setParola(e.target.value)}
                                required
                            />
                        </div>
                        <div className="save-button">
                            <button type="submit" onClick={handleUpdatePersonal}>
                                Salvează Preferințe
                            </button>
                        </div>
                    </div>

                    <div className="update-right">
                        <h2>Informații Profil</h2>
                        <div className="input-field">
                            <label htmlFor="inaltime">Înălțime (cm):</label>
                            <input
                                type="number"
                                id="inaltime"
                                value={inaltime}
                                onChange={(e) => setInaltime(e.target.value)}
                                required
                            />
                        </div>
                        <div className="input-field">
                            <label htmlFor="greutate">Greutate (kg):</label>
                            <input
                                type="number"
                                id="greutate"
                                value={greutate}
                                onChange={(e) => setGreutate(e.target.value)}
                                required
                            />
                        </div>
                        <div className="save-button">
                            <button type="submit" onClick={handleUpdateProfile}>
                                Salvează Preferințe
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default UpdateProfile;
