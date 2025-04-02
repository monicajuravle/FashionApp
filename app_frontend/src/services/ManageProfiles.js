import React, { useEffect, useState } from "react";

const ManageProfiles = () => {
    const [users, setUsers] = useState([]);
    const sixMonthsAgo = new Date();
    sixMonthsAgo.setMonth(sixMonthsAgo.getMonth() - 6);

    useEffect(() => {
        // Fetch utilizatori din backend
        fetch("http://localhost:8080/api/utilizatori/all")
            .then((response) => response.json())
            .then((data) => setUsers(data))
            .catch((error) => console.error("Error fetching users:", error));
    }, []);

    const handleDelete = (id) => {
        fetch(`http://localhost:8080/api/utilizatori/${id}`, {
            method: "DELETE",
        })
            .then((response) => {
                if (response.ok) {
                    // Actualizează lista locală după ștergere
                    setUsers(users.filter((user) => user.idUtilizator !== id));
                }
            })
            .catch((error) => console.error("Error deleting user:", error));
    };

    return (
        <div className="manage-profiles">
            <h2>Gestionare Profile Utilizatori</h2>
            <div className="user-list">
                {users.length > 0 ? (
                    users.map((user) => {
                        const lastActivity = new Date(user.ultimaActivitate);
                        const isInactive = lastActivity < sixMonthsAgo;

                        return (
                            <div key={user.idUtilizator} className="user-card">
                                <p>Email: {user.email}</p>
                                <p>Ultima Activitate: {lastActivity.toLocaleDateString()}</p>
                                {isInactive && (
                                    <button
                                        onClick={() => handleDelete(user.idUtilizator)}
                                        className="delete-button"
                                    >
                                        Șterge Utilizator Inactiv
                                    </button>
                                )}
                            </div>
                        );
                    })
                ) : (
                    <p>Nu există utilizatori disponibili.</p>
                )}
            </div>
        </div>
    );
};

export default ManageProfiles;
