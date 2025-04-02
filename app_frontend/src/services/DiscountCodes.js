import React, { useEffect, useState } from "react";

const DiscountCodes = () => {
    const [eligibleUsers, setEligibleUsers] = useState([]);
    const [discountCode, setDiscountCode] = useState("");

    useEffect(() => {
        // Fetch utilizatorii eligibili pentru reducere
        fetch("http://localhost:8080/api/discounts/eligible-users")
            .then((response) => response.json())
            .then((data) => setEligibleUsers(data))
            .catch((error) => console.error("Error fetching eligible users:", error));
    }, []);

    const handleGenerateCode = (userId) => {
        // Apelează endpoint-ul pentru a genera un cod de reducere
        fetch("http://localhost:8080/api/discounts/generate-code", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userId),
        })
            .then((response) => response.text())
            .then((code) => {
                setDiscountCode(code); // Afișează codul de reducere generat
                alert(`Codul de reducere pentru utilizatorul cu ID ${userId} este: ${code}`);
            })
            .catch((error) => console.error("Error generating discount code:", error));
    };

    return (
        <div>
            <h2>Generare Coduri Reducere</h2>
            <ul>
                {eligibleUsers.map((user) => (
                    <li key={user.idUtilizator}>
                        <p>{user.nume} {user.prenume} - {user.email}</p>
                        <button onClick={() => handleGenerateCode(user.idUtilizator)}>
                            Generează Cod Reducere
                        </button>
                    </li>
                ))}
            </ul>
            {discountCode && <p>Codul de reducere generat: {discountCode}</p>}
        </div>
    );
};

export default DiscountCodes;
