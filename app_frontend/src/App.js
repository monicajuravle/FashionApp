import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from "./components/Register";
import Preferences from "./services/Preferences";
import Login from "./auth/Login";
import ClientDashboard from "./components/ClientDashboard";
import UpdateProfile from "./components/UpdateProfile";
import OccasionOutfit from "./components/OccasionOutfit";
import AddProduct from "./components/AddProduct";
import AdminDashboard from "./components/AdminDashboard";
import ProductCatalog from "./components/ProductCatalog";
import ManageProfiles from "./services/ManageProfiles";
import DiscountCodes from "./services/DiscountCodes";
import Recomandari from "./components/Recomandari";
import Cart from "./components/Cart";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/preferences" element={<Preferences />} />
                <Route path="/clientDashboard" element={<ClientDashboard />} />
                <Route path="/updateProfile" element={<UpdateProfile />} />
                <Route path="/outfits/:occasion" element={<OccasionOutfit />} />
                <Route path="admin/product-catalog/addProduct" element={<AddProduct />} />
                <Route path="/adminDashboard/*" element={<AdminDashboard />} />
                <Route path="/admin/product-catalog" element={<ProductCatalog />} />
                <Route path="/admin/inactive-profiles" element={<ManageProfiles />} />
                <Route path="/admin/discount-codes" element={<DiscountCodes />} />
                <Route path="/admin/recommendations" element={<Recomandari />} />
                <Route path="/cart" element={<Cart />} />
            </Routes>
        </Router>
    );
};

export default App;
