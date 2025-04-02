import React from "react";
import { useNavigate } from "react-router-dom";
import  { useEffect, useState } from 'react';
import "../styles/ClientDashboard.css";

const ClientDashboard = () => {
    const navigate = useNavigate();
    /*useEffect(() => {
        // Retrieve data from localStorage
        const utilizator = localStorage.getItem('idUtilizator');
        if (storedData) {
            setData(JSON.parse(storedData)); // Parse the data if available
        }
    }, []);*/


    const handleOccasionSelect = (occasion) => {
        // Navigăm către pagina ținutelor, trecând ocazia ca parametru
        navigate(`/outfits/${occasion}`);
    };

    const handleNavigation = (path) => {
        navigate(path); // Navighează către calea dorită
    };

    return (
        <div className="client-dashboard-container">
            <div className="navbar">
                <div className="navbar-logo">Fashion Consultant</div>
                <div className="navbar-buttons">
                    <button className="navbar-btn" onClick={() => handleNavigation("/updateProfile")}>Update Profil</button>
                    <button className="navbar-btn" onClick={() => handleNavigation("/cart")}>Cos</button>
                    <button className="navbar-btn" onClick={() => handleNavigation("/signout")}>Sign Out</button>
                </div>
            </div>

            <div className="content-area">
                <div className="welcome-message">
                    <h1>Bun venit!</h1>
                    <p>Explorați sfaturi de modă personalizate și multe altele!</p>
                </div>

                <div className="occasion-selection">
                    <h2>Alegeți o ocazie</h2>
                    <div className="scrollable-occasions">
                        <button className="occasion-btn" onClick={() => handleOccasionSelect("Întâlnire")}>Întâlnire</button>
                        <button className="occasion-btn" onClick={() => handleOccasionSelect("Birou")}>Birou</button>
                        <button className="occasion-btn" onClick={() => handleOccasionSelect("Casual")}>Casual</button>
                        <button className="occasion-btn" onClick={() => handleOccasionSelect("Nuntă")}>Nuntă</button> {/* Adăugat butonul pentru Nuntă */}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ClientDashboard;
