// components/GuestPage.js
import React from 'react';
import FlightList from './FlightList';

const GuestPage = () => (
    <div>
        <h1>Welcome Guest</h1>
        <FlightList showBooking={false} />
        <p>Please login to book tickets.</p>
    </div>
);

export default GuestPage;
