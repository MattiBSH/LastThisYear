import React, {useState} from "react";
import "./style2.css";
import Header from "./Header";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  NavLink
} from "react-router-dom";

// This site has 3 pages, all of which are rendered
// dynamically in the browser (not server rendered).
//
// Although the page does not ever refresh, notice how
// React Router keeps the URL up to date as you navigate
// through the site. This preserves the browser history,
// making sure things like the back button and bookmarks
// work properly.

export default function BasicExample() {
  return (
    <Router>
      <div>
        <Header/>

        <hr />

        {/*
          A <Switch> looks through all its children <Route>
          elements and renders the first one whose path
          matches the current URL. Use a <Switch> any time
          you have multiple routes, but you want only one
          of them to render at a time
        */}
        <div className="content">

        <Switch>
          <Route exact path="/">
            <Exercise1 />
          </Route>
          <Route path="/Exercise2">
            <Exercise2 />
          </Route>
          <Route path="/Exercise3">
            <Exercise3 />
          </Route>
        </Switch>
      </div>
      </div>
    </Router>
    
  );
}

// You can think of these components as "pages"
// in your app.

function Exercise1() {
    // Declare a new state variable, which we'll call "count"
    const [count, setCount] = useState(0);
  
  return (
    <div>
      <h2>Exercise1</h2>
    
      <p>You clicked {count} times</p>
      <button onClick={() => setCount(count + 1)}>
        Click me
      </button>
    </div>
  );
}
    


function Exercise2() {
  return (
    <div>
      <h2>Exercise2</h2>
    </div>
  );
}

function Exercise3() {
  return (
    <div>
      <h2>Exercise3</h2>
    </div>
  );
}
