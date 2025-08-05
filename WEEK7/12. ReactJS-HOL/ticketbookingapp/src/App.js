import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

function App() {
    const [loggedIn, setLoggedIn] = useState(false);

    return (
        <div className="App">
            <h1>Ticket Booking App</h1>
            <div>
                {loggedIn ? (
                    <button onClick={() => setLoggedIn(false)}>Logout</button>
                ) : (
                    <button onClick={() => setLoggedIn(true)}>Login</button>
                )}
            </div>

            <hr />

            {loggedIn ? <UserPage /> : <GuestPage />}
        </div>
    );
}

export default App;
