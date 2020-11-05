
 

import React, { useState } from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    NavLink
  } from "react-router-dom";
function Header() {
  return (
    <div>
        <ul className="header">
          <li>
          <NavLink exact activeClassName="selected" to="/">Home</NavLink>
          </li>
          <li>
            <NavLink to="/Exercise2">About</NavLink>
          </li>
          <li>
            <NavLink to="/Exercise3">Dashboard</NavLink>
          </li>
        </ul>
    </div>
  );
}
export default Header;