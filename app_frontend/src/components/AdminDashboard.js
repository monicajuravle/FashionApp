import React from "react";
import { Link, Routes, Route } from "react-router-dom";
import "../styles/AdminDashboard.css";
import ManageProfiles from "../services/ManageProfiles";
import Recomandari from "./Recomandari";

// Componente pentru funcționalități
const InactiveProfiles = () => <div>Ștergerea profilelor utilizatorilor inactivi</div>;
const ProductCatalog = () => <div>Gestionarea catalogului de produse</div>;
const Recommendations = () => <div>Recomandări bazate pe preferințe și ocazie</div>;
const DiscountCodes = () => <div>Generarea codurilor de reducere</div>;

const AdminDashboard = () => {
    return (
        <div className="admin-dashboard">
            {/* Navbar fixat sus */}
            <nav className="navbar">
                <ul>
                    <li><Link to="/admin/inactive-profiles">Gestionare profile</Link></li>
                    <li><Link to="/admin/product-catalog">Catalog Produse</Link></li>
                    <li><Link to="/admin/recommendations">Recomandări</Link></li>
                    <li><Link to="/admin/discount-codes">Coduri Reducere</Link></li>
                </ul>
            </nav>

            {/* Conținutul paginii */}
            <div className="content">
                <div className="center-text">
                    <h2>Bine ai venit în pagina principală a adminului!</h2>
                    <p>Gestionează preferințele utilizatorilor, catalogul de produse și multe altele.</p>
                </div>

                <Routes>
                    <Route path="inactive-profiles" element={<ManageProfiles  />} />
                    <Route path="product-catalog" element={<ProductCatalog />} />
                    <Route path="recommendations" element={<Recomandari />} />
                    <Route path="discount-codes" element={<DiscountCodes />} />
                </Routes>
            </div>
        </div>
    );
};

export default AdminDashboard;
