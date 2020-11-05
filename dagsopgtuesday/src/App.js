
import Header from './Header'
import Home from './Home'
import Products from './Products'
import Company from './Company'
import NoMatch from './NoMatch'
import AddBook from './AddBook'

import "./App.css";
import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams,
  useRouteMatch,
  NavLink,
} from "react-router-dom";
import FindBook from './FindBook'
function App(props) {
  return (
    <div>
  <Header />
  <Switch>
    <Route exact path="/">
      <Home />
    </Route>
    <Route path="/products">
      <Products bF={props.bookFacade}/>
    </Route>
    <Route path="/company">
      <Company />
    </Route>
    <Route path="/addBook">
      <AddBook bF={props.bookFacade}/>
    </Route>
    <Route path="/findBook">
      <FindBook bF={props.bookFacade}/>
    </Route>
    <Route>
      <NoMatch />
    </Route>
  </Switch>
</div>
  );
}

export default App;
