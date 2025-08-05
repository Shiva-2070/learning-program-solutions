import React from 'react';
import ListofPlayers from './Component/ListofPlayers';
import IndianPlayers from './Component/IndianPlayers';



function App() {
  const flag = true;

  return (
    <div>
      <h1>🏏 Cricket App</h1>
      {flag ? <ListofPlayers/> : <IndianPlayers/>}
    </div>
  );
}

export default App;
