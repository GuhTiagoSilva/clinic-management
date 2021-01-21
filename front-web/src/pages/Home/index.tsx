import React from 'react';
import { Link } from 'react-router-dom'
import { ReactComponent as MainImage } from '../../core/assets/images/main-image.svg'
import ButtonIcon from '../../core/components/ButtonIcon';
import './styles.scss'

const Home = () => {
    return (
        <div className="home-container">
            <div className="row home-content card-base border-radius-20">
                <div className="col-6">
                    <h1 className="text-title">
                        Gestão Inteligente <br /> de cadastros de médicos
                </h1>
                    <p className="text-subtitle">
                        Ajudaremos você a gerenciar melhor <br />  os médicos dentro de seu hospital.
                </p>

                    <Link to="/users">
                        <ButtonIcon text="inicie agora o cadastro" />
                    </Link>

                </div>

                <div className="col-6">
                    <MainImage className="main-image" />
                </div>


            </div>
        </div>
    );
}

export default Home;