import "./styles.css";
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      <div className="home-container">
        <div className="home-content">
          <div className="home-actions">
            <h1 className="home-title">
              TS Caixa
            </h1>
            <Link to="/depositos" className="home-btn-order">
              Listar
            </Link>
            <br/>
            <Link to="/depositos" className="home-btn-order">
              Depositar
            </Link>
            <br/>
            <Link to="/depositos" className="home-btn-order">
              Transferir
            </Link>
            <br/>
            <Link to="/depositos" className="home-btn-order">
              Extrato
            </Link>
          </div>
        </div>
      </div>
    </>
  );
}
export default Home;
