import './styles.css';
import { Link } from 'react-router-dom';

function Navbar () {
    return(
        <nav className="main-navbar">
            <Link to="/" className="logo-text">TS Caixa</Link>
        </nav>
    );
}
export default Navbar;