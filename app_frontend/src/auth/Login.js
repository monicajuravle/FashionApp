import React, { useState } from "react";
import { useNavigate } from "react-router-dom"; // Importă hook-ul useNavigate
import "../styles/Login.css";

const Login = ({ onLogin }) => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [role, setRole] = useState("client");
    const navigate = useNavigate(); // Hook pentru navigare

    const handleSubmit = async (e) => {
        e.preventDefault();

        const loginData = { email, password, role };

        try {
            const response = await fetch("http://localhost:8080/api/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(loginData),
            });

            if (response.ok) {
                const responseData = await response.json();
                console.log(responseData);
                localStorage.setItem("idUtilizator", responseData.idUtilizator);
                if(responseData.role==="ADMINISTRATOR")
                {
                    navigate("/adminDashboard");
                }
                else
                navigate("/clientDashboard");
            } else {
                alert("Login failed. Please check your credentials and try again.");
            }
        } catch (error) {
            console.error("Error while logging in:", error);
            alert("An error occurred. Please try again later.");
        }
    };


    const handleSwitchToRegister = () => {
        navigate("/register");
    };

    return (
        <div className="login-container">
            <h2>Welcome to your new fashion consultant</h2>
            <p>Log in to explore personalized fashion advice and more!</p>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <select value={role} onChange={(e) => setRole(e.target.value)}>
                    <option value="CLIENT">CLIENT</option>
                    <option value="ADMINISTRATOR">ADMINISTRATOR</option>
                </select>
                <button type="submit">Login</button>
            </form>
            <div className="switch">
                Don't have an account?{" "}
                <span onClick={handleSwitchToRegister} className="link">
                    Create one
                </span>
            </div>
        </div>
    );
};

export default Login;
