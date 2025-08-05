// components/UserPage.js
import React from 'react';
import FlightList from './FlightList';

const UserPage = () => (
    <div>
        <h1>Welcome User</h1>
        <FlightList showBooking={true} />
    </div>
);

export default UserPage;
