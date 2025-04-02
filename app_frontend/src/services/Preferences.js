import React, { useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "../styles/Login.css";

const Preferences = () => {
    const location = useLocation(); // Access location from react-router-dom
    const user = location.state?.user;
    const [height, setHeight] = useState("");
    const [weight, setWeight] = useState("");
    const [selectedColors, setSelectedColors] = useState([]);
    const [colors, setColors] = useState([]);
    const navigate = useNavigate();

    // Fetch colors from the backend API endpoint
    useEffect(() => {
        const fetchColors = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/culori");
                const data = await response.json();
                setColors(data); // Store the list of colors
            } catch (error) {
                console.error("Error fetching colors:", error);
                alert("Failed to load colors. Please try again later.");
            }
        };

        fetchColors();
    }, []);

    // Handle the form submission to update the profile
    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!user || !user.idUtilizator) {
            alert("User ID is missing!");
            return;
        }
        try {
            const response = await fetch("http://localhost:8080/api/profile", {
                method: "POST", // Using POST for creating a new profile
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    idUtilizator: user.idUtilizator, // User ID
                    greutate: weight,
                    inaltime: height,
                    idColors:  selectedColors, // Array of selected color IDs
                }),
            });

            if (response.ok) {
                alert("Profile updated successfully!");
                navigate("/"); // Navigate to home or another destination
            } else {
                const errorData = await response.json();
                alert(`Failed to update profile: ${errorData.message}`);
            }
        } catch (error) {
            console.error("Error while updating profile:", error);
            alert("An error occurred. Please try again later.");
        }
    };

    // Handle the color selection change
    const handleColorChange = (e) => {
        const options = e.target.options;
        const selected = [];
        for (let i = 0; i < options.length; i++) {
            if (options[i].selected) {
                selected.push(options[i].value); // Push the selected color IDs
            }
        }
        setSelectedColors(selected); // Update the selected colors state
    };

    return (
        <div className="login-container">
            <h2>Update Your Profile</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="number"
                    placeholder="Height (cm)"
                    value={height}
                    onChange={(e) => setHeight(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Weight (kg)"
                    value={weight}
                    onChange={(e) => setWeight(e.target.value)}
                    required
                />
                <label>Select Your Favorite Colors:</label>
                <select
                    multiple
                    value={selectedColors}
                    onChange={handleColorChange}
                    style={{
                        height: "150px",
                        width: "100%",
                        marginBottom: "20px",
                        padding: "10px",
                        borderRadius: "5px",
                        border: "1px solid #ccc",
                        fontSize: "16px",
                        backgroundColor: "#fff",
                        overflow: "auto",
                    }}
                >
                    {colors.map((color) => (
                        <option key={color.idCuloare} value={color.idCuloare}>
                            {color.numeCuloare} {/* Display color name */}
                        </option>
                    ))}
                </select>
                <button type="submit">Save Profile</button>
            </form>
        </div>
    );
};

export default Preferences;
