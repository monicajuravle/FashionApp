import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Hook pentru navigare
import "../styles/Login.css";


const Register = () => {
    // Definim stările pentru fiecare câmp din formular
    const [nume, setFirstName] = useState("");
    const [prenume, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [parola, setPassword] = useState("");
    const [confirmParola, setConfirmPassword] = useState("");
    const navigate = useNavigate();

    // Gestionăm submit-ul formularului
    const handleSubmit = async (e) => {
        e.preventDefault();

        // Verificăm dacă parolele se potrivesc
        if (parola !== confirmParola) {
            alert("Passwords do not match!");
            return;
        }

        const userData = {
            nume,
            prenume,
            email,
            parola,
        };

        // Trimitem datele la backend pentru a înregistra utilizatorul
        try {
            const response = await fetch("http://localhost:8080/api/utilizatori", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(userData),
            });

            if (response.ok) {
                const responseData = await response.json();  // Receive the entire Utilizator object
                alert("Account created successfully!");

                // Navigate to preferences and pass the entire Utilizator object as state
                navigate("/preferences",{ state: { user: responseData } });
            } else {
                const errorData = await response.json();
                console.error("Error:", errorData);
                alert("Failed to create account: " + errorData.message);
            }
        } catch (error) {
            console.error("Error:", error);
            alert("An unexpected error occurred.");
        }
    };

    // Navigăm înapoi la login
    const handleSwitchToLogin = () => {
        navigate("/"); // Navighează la pagina de login
    };

    return (
        <div className="login-container">
            <h2>Welcome to your new fashion consultant</h2>
            <p>Create an account to get started!</p>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="First Name"
                    value={nume}
                    onChange={(e) => setFirstName(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Last Name"
                    value={prenume}
                    onChange={(e) => setLastName(e.target.value)}
                    required
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={parola}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Confirm Password"
                    value={confirmParola}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                    required
                />
                <button type="submit">Create Account</button>
            </form>
            <div className="switch">
                Already have an account?{" "}
                <span onClick={handleSwitchToLogin} className="link">
                    Log in
                </span>
            </div>
        </div>
    );
};

export default Register;
